import axiosInstance from "../axios/axios.js";

const hostRepository = {
    findAll: async () => {
        return await axiosInstance.get("/hosts");
    },
    findById: async (id) => {
        return await axiosInstance.getElementById(`/hosts/${id}`);
    },
    add: async (body) => {
        return await axiosInstance.post("/hosts/add", body);
    },
    edit: async (id, body) => {
        return await axiosInstance.put(`/hosts/edit/${id}`, body);
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/hosts/delete/${id}`);
    },
};

export default hostRepository;