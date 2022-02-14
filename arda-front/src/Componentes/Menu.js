import React, { useContext } from 'react'
import { Container, Navbar, Nav, NavDropdown, Row, Col } from 'react-bootstrap'
import { GiTripleClaws } from 'react-icons/gi'
import { Link } from 'react-router-dom';
import UserContext from '../Context/UserContext';

function Menu(props) {
    const { Loged, closeSesion } = useContext(UserContext);
    return (
        <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
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
                            <NavDropdown title="Administar Iguanas" id="collasible-nav-dropdown">
                                <NavDropdown.Item href="#action/3.1">Registar Iguana</NavDropdown.Item>
                                <NavDropdown.Item href="#action/3.3">Ver iguanas</NavDropdown.Item>
                            </NavDropdown>
                            : <Nav.Link href="#action">Contactenos</Nav.Link>
                        }
                        {Loged
                            ?
                            <Nav.Link as={Link} to="/terrarios">Administrar Terrarios</Nav.Link>
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
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default Menu;