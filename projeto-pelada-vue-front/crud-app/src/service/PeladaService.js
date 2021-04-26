import axios from 'axios';

export default class PeladaService {

    url = "http://localhost:8081/peladas";

    getAll() {
        return axios.get(this.url);
    }
    
    save(pelada) {
        return axios.post(this.url, pelada);
    }

    delete(id) {
        return axios.delete(this.url + "/"+ id);
    }


}