import React from 'react'
import ReactDOM from 'react-dom/client'
// import App from './App.jsx'
import './index.css'
import App1 from './App1.jsx'
import { createRoot } from "react-dom/client";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom"
import MainPage from './MainPage.jsx';
import AddPage from './AddPage.jsx';
import DetailsPage from './DetailsPage.jsx';

const NotFound=()=>{
  return <h2 style={{fontSize:"100px"}}>Page Not Found</h2>
}
ReactDOM.createRoot(document.getElementById('root')).render(
  // <React.StrictMode>
  //   <App/>
  //   <span className="loader"></span>
  //   <App1 />
  // </React.StrictMode>,
  <BrowserRouter>
  <Routes>
      <Route path="/movies" element={<App1/>}></Route>
      <Route path="*" element={<Navigate to="/not-found"/>}></Route>
      <Route path="/not-found" element={<NotFound/>}></Route>
      <Route path="/main" element={<MainPage/>}></Route>
      <Route path="/add-movie" element={<AddPage/>}></Route>
      <Route path="/movie/:id" element={<DetailsPage/>}></Route>
      <Route path="/:genre" element={<App1/>}></Route>
  </Routes>
  </BrowserRouter>
)
