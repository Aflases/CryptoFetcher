import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { CryptoModalData } from '../pages/util/util';
import { fetchCryptoData } from '../service/cryptoService';

interface CryptoState {
  data: CryptoModalData | null;
  status: 'idle' | 'loading' | 'succeeded' | 'failed';
  error: string | null;
}

const initialState: CryptoState = {
  data: null,
  status: 'idle',
  error: null,
};

export const fetchCryptoDataThunk = createAsyncThunk<CryptoModalData, string>(
  'crypto/fetchCryptoData',
  async (code: string) => {
    const data = await fetchCryptoData(code);
    return data;
  }
);

const cryptoSlice = createSlice({
  name: 'crypto',
  initialState,
  reducers: {},
  extraReducers: (builder:any) => {
    builder
      .addCase(fetchCryptoDataThunk.pending, (state:any) => {
        state.status = 'loading';
      })
      .addCase(fetchCryptoDataThunk.fulfilled, (state:any, action:any) => {
        state.status = 'succeeded';
        state.data = action.payload;
      })
      .addCase(fetchCryptoDataThunk.rejected, (state:any, action:any) => {
        state.status = 'failed';
        state.error = action.error.message || 'Failed to fetch data';
      });
  },
});

export default cryptoSlice.reducer;
