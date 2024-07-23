import React, { useEffect, useState } from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Typography } from '@mui/material';
import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch, RootState } from '../../Redux/store/store';
import { fetchCryptoDataThunk } from '../../Redux/CryptoSlice';

interface HistoryTableProps {
  code: string;
}

const HistoryTable: React.FC<HistoryTableProps> = ({ code }) => {
    console.log('HistoryTable');
    
  const dispatch: AppDispatch = useDispatch();
  const history = useSelector((state: RootState) => state.crypto.data?.history);
  const status = useSelector((state: RootState) => state.crypto.status);
  const error = useSelector((state: RootState) => state.crypto.error);

  useEffect(() => {
    dispatch(fetchCryptoDataThunk(code));
    const intervalId = setInterval(() => {
      dispatch(fetchCryptoDataThunk(code));
    }, 10000);

    return () => clearInterval(intervalId);
  }, [dispatch, code]);

  if (status === 'loading') {
    return <div>Loading...</div>;
  }

  if (status === 'failed') {
    return <div>Error: {error}</div>;
  }

  if (!history) {
    return <div>No history data available</div>;
  }

  return (
    <div>
      <Typography variant="h6" gutterBottom>
        History
      </Typography>
      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
                <TableCell>No.</TableCell>
              <TableCell>Date</TableCell>
              <TableCell>Rate</TableCell>
              <TableCell>Volume</TableCell>
              <TableCell>Cap</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {history.map((entry:any, index:number) => (
              <TableRow key={index}>
                <TableCell>{index+1}</TableCell>
                <TableCell>{entry.date}</TableCell>
                <TableCell>{entry.rate}</TableCell>
                <TableCell>{entry.volume.toLocaleString()}</TableCell>
                <TableCell>{entry.cap.toLocaleString()}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default HistoryTable;
