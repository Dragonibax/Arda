import React from 'react';
import { Col, Container } from 'react-bootstrap';
import { Chart } from 'react-google-charts';

function Humedad({data}) {
    const options = {
        chart: {
            title: "Humedad del terrario",
            subtitle: "En porcentaje",
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

export default Humedad;