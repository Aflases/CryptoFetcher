import axios from "axios";


export const fetchCryptoData = async (code: string) => {
  try {
    const response = await axios.get('http://localhost:8080/api/crypto/'+code);
    console.log(response.data);
    
    return response.data;
  } catch (error) {
    throw new Error('Error fetching crypto data');
  }
};
