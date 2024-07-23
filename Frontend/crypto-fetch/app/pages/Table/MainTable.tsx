import React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Typography } from '@mui/material';
import { CryptoModalData } from '../util/util';

interface MainTableProps {
  data: CryptoModalData|null;
}

const MainTable: React.FC<MainTableProps> = ({ data }) => {
  return (
    <div>
      <Typography variant="h4" gutterBottom>
        Crypto Table
      </Typography>
      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Name</TableCell>
              <TableCell>Symbol</TableCell>
              <TableCell>Rank</TableCell>
              <TableCell>Age</TableCell>
              <TableCell>Color</TableCell>
              <TableCell>Exchanges</TableCell>
              <TableCell>Markets</TableCell>
              <TableCell>Rate</TableCell>
              <TableCell>Volume</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            <TableRow>
              <TableCell key={'name'+data?.name}>{data?.name}</TableCell>
              <TableCell key={'symbol' + data?.symbol}>{data?.symbol}</TableCell>
              <TableCell key={'rank'+data?.rank}>{data?.rank}</TableCell>
              <TableCell key={'age'+data?.age}>{data?.age}</TableCell>
              <TableCell key={'color'+data?.color}>
                <div style={{ backgroundColor: data?.color, width: '24px', height: '24px', borderRadius: '50%' }}></div>
              </TableCell>
              <TableCell key={'ex'+data?.exchanges}>{data?.exchanges}</TableCell>
              <TableCell key= {'market'+data?.markets}>{data?.markets}</TableCell>
              <TableCell key= {'rate'+data?.rate}>{data?.rate}</TableCell>
              <TableCell key= {'volumne'+data?.volume}>{data?.volume}</TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default React.memo(MainTable);
