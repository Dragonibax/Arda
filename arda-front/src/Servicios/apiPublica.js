import axios from 'axios';

export default axios.create({
    baseURL: 'https://localhost:9898/api/public/'
})