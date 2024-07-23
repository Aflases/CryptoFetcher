interface History {
    date: number;
    rate: number;
    volume: number;
    cap: number;
    liquidity: number;
}

export interface CryptoModalData {
    name: string;
    symbol: string;
    rank: number;
    age: number;
    color: string;
    exchanges: number;
    markets: number;
    allTimeHighUSD: number;
    circulatingSupply: number;
    totalSupply: number;
    maxSupply: number;
    rate: number;
    volume: number;
    history: History[]; 
}
