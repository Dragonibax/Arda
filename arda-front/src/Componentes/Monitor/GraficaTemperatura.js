import React from 'react';
import { Col, Container } from 'react-bootstrap';
import { Chart } from 'react-google-charts';

function Temperatura({data}) {
    const options = {
        chart: {
            title: "Temperatura del terrario",
            subtitle: "En grados Celcius",
        },
    }
    return (
        <Col>
        <Container>
            <Chart
                chartType='Line'
                width="100%"
                height="300%"
                data={data}
                options={options}
            />
        </Container>
        </Col>
    );
}

export default Temperatura;