import axiosInstance from "../axios/axios.js";

const accommodationRepository = {
    findAll: async () => {
        return await axiosInstance.get("/accommodations");
    },
    findById: async (id) => {
        return await axiosInstance.getElementById(`/accommodations/${id}`);
    },
    add: async (body) => {
        return await axiosInstance.post("/accommodations/add", body);
    },
    edit: async (id, body) => {
        return await axiosInstance.put(`/accommodations/edit/${id}`, body);
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/accommodations/delete/${id}`);
    },
};

export default accommodationRepository;