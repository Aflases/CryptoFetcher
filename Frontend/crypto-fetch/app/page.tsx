'use client'
import Image from "next/image";
import { Provider } from 'react-redux';
import {store} from './Redux/store/store'
import CrytpoFetcher from "./pages/CrytpoFetcher";

export default function Home() {
  return (
    <Provider store={store}>
    <CrytpoFetcher/>
    </Provider>
  );
}