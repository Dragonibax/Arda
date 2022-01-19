import React from 'react'
import { Container, Navbar, Nav, NavDropdown } from 'react-bootstrap'
import {GiTripleClaws} from 'react-icons/gi'

function Menu(props) {
    return (
                <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                    <Container fluid>
                        <Navbar.Brand href="#home">
                            <GiTripleClaws className="d-inline-block align-top"/>
                            {' '}
                            ARDA
                        </Navbar.Brand>
                        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                        <Navbar.Collapse id="responsive-navbar-nav">
                            <Nav className="me-auto">
                                <Nav.Link href="#features">Monitor</Nav.Link>
                                <Nav.Link href="#pricing">Aquirir un terrario</Nav.Link>{/* Condicionar segun inicio de Sesion*/ }
                                <NavDropdown title="Administar Iguanas" id="collasible-nav-dropdown">
                                    <NavDropdown.Item href="#action/3.1">Registar Iguana</NavDropdown.Item>
                                    <NavDropdown.Item href="#action/3.3">Ver iguanas</NavDropdown.Item>
                                </NavDropdown>
                                <NavDropdown title="Administar Terrarios" id="collasible-nav-dropdown">
                                    <NavDropdown.Item href="#action/3.1">Monitorear Terrario</NavDropdown.Item>
                                    <NavDropdown.Item href="#action/3.2">Editar datos de terrario</NavDropdown.Item>
                                    <NavDropdown.Divider />
                                    <NavDropdown.Item href="#action/3.4">Registrar un Terrario</NavDropdown.Item>
                                </NavDropdown>
                            </Nav>
                            <Nav>
                                <Nav.Link href="#deets">Perfil</Nav.Link>
                                <Nav.Link eventKey={2} href="#memes">
                                    Cerrar Sesion
                                </Nav.Link>
                            </Nav>
                        </Navbar.Collapse>
                    </Container>
                </Navbar>
    );
}

export default Menu;