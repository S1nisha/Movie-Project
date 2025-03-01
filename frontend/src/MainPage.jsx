import React from 'react'
import './App1.css'
import Header from './components/Header'
import ControlledCarousel from './components/Carousel'
import GroupExample from './components/Cards'
const MainPage=()=>{
  return (

    <>
    <div className='content'>
    <Header/>

    <ControlledCarousel/>
    <h2 style={{marginBottom: "3%"}}>Featured Movies</h2>
    <GroupExample/>
    </div>
    
    </>
  )
}

export default MainPage

