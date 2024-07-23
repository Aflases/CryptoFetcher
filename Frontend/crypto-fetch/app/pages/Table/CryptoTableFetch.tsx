import React from 'react'
import MainTable from './MainTable';
import HistoryTable from './HistoryTable';
import { useSelector } from 'react-redux';
import { RootState } from '@/app/Redux/store/store';

interface CryptoTableProps {
    code:string
}

const CryptoTableFetch = ({code}:CryptoTableProps) => {
    const cryptoData = useSelector((state: RootState) => state.crypto.data);

    return (
        <div>
          <MainTable data={cryptoData} />
          <HistoryTable code={code} />
        </div>
      );
}

export default CryptoTableFetch