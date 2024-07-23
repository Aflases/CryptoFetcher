import { Box, Button } from '@mui/material'
import React, { useState } from 'react'
import CryptoTableFetch from './Table/CryptoTableFetch'

const CryptoFetchComp = () => {

    const [selectedCode, setselectedCode] = useState('BTC')

    const CryptCurrency = [{code:'BTC',color:'#fa9e32'},
        {code:"ETH",color:'blue'},{code:'BNB',color:"#f4bc2c"},{
            code:"SOL",color:'#7370e8'
        },{code:'USDT',color:'blue'}

    ]

    const onClickHandler =(code:string)=>{
        setselectedCode(code);
    }
  return (
    <>
    <Box 
      display="flex" 
      justifyContent="center" 
      alignItems="center" 
      p={2}
    >
        {
            CryptCurrency.map((ele,index) => 
                (<Button variant="contained" sx={{ mx: 1 }} key={index} style={{backgroundColor:`${ele.color}`}} onClick={()=>onClickHandler(ele.code)}>{ele.code}</Button>)

            )
        }
    </Box>
    <CryptoTableFetch code={selectedCode}/>
    </>
  )
}

export default CryptoFetchComp