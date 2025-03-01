import React from "react";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
function Header() {
    return (
      <Navbar bg="dark" data-bs-theme="dark" className="header">
        <Container>
          <Navbar.Brand href="/main" style={{marginLeft: "20px"}}><h1 style={{ fontStyle: "italic"}}>Cinemaxx</h1></Navbar.Brand>
          <Nav className="me-auto" style={{marginLeft: "3%"}}>
            <Nav.Link href="/movies"><h5>Movies</h5></Nav.Link>
          </Nav>
          <Nav>
            <Nav.Link href="/login" className="d-flex"><h5>Login</h5></Nav.Link>
            </Nav>
        </Container>
      </Navbar>
    );
  }
  
  export default Header;