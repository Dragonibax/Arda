import React, { useContext } from 'react'
import { Container, Navbar, Nav, NavDropdown, Row, Col } from 'react-bootstrap'
import { GiTripleClaws } from 'react-icons/gi'
import { Link } from 'react-router-dom';
import UserContext from '../Context/UserContext';

function Menu(props) {
    const { Loged, closeSesion } = useContext(UserContext);
    return (
        <Navbar sticky="top" collapseOnSelect expand="lg" bg="dark" variant="dark" className='sabbar'>
            <Container fluid>
                <Navbar.Brand as={Link} to="/">
                
                    <Row xs={4}>
                        <Col className="d-inline-block align-content-center">
                            <GiTripleClaws/>
                            {' '}
                        </Col>
                        <Col className='title-Arda'>
                                Arda
                        </Col>
                    </Row>
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="me-auto">
                        {Loged
                            ? <Nav.Link as={Link} to={"/monitor-principal"}>Monitor</Nav.Link>
                            : <Nav.Link href="#pricing">Aquirir un terrario</Nav.Link>}
                        {Loged
                            ?
                            <Nav.Link as={Link} to="/Contacto">Contactos</Nav.Link>
                            : <Nav.Link href="#action">Contactenos</Nav.Link>
                        }
                        {Loged
                            ?
                   
                            <NavDropdown title="Terrarios" id="basic-nav-dropdown">
                                <NavDropdown.Item href="/terrarios">Ver Terraios</NavDropdown.Item>
                                <NavDropdown.Item href="/Masterrario">Añadir Terrarios</NavDropdown.Item>
                            </NavDropdown>
                            : ""
                        }
                    </Nav>
                    <Nav>
                        {Loged
                            ?
                            <Nav.Link eventKey={2} onClick={closeSesion}>
                                Cerrar Sesion
                            </Nav.Link>
                            : <Nav.Link eventKey={2} as={Link} to="/login">
                                Iniciar Sesion
                            </Nav.Link>
                        }
                        {Loged
                            ?
                            ""
                            : <Nav.Link eventKey={2} as={Link} to="/signin">Crear Usuario</Nav.Link>
                        }
                    </Nav>
                
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default Menu;

//<Nav.Link as={Link} to="/terrarios">Administrar Terrarios</Nav.Link>
         