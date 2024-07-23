import { Box, Typography, Button, Container } from '@mui/material';

const JumbotronHead = () => {
  return (
    <Container maxWidth="lg">
      <Box
        sx={{
          padding: '4rem',
          textAlign: 'center',
          borderRadius: '8px',
          boxShadow: 3,
          marginTop: '2rem',
          marginBottom: '2rem',
        }}
      >
        <Typography variant="h1" gutterBottom>
          Welcome to CryptoFetcher
        </Typography>
        <Typography variant="h5" gutterBottom>
          Real-time stock data at your fingertips
        </Typography>
        <Typography variant="body1" paragraph>
          Stay ahead of the market with live updates on 5 stocks, refreshed every 45 seconds.
        </Typography>
       
      </Box>
    </Container>
  );
};

export default JumbotronHead;
