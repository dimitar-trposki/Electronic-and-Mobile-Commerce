import axiosInstance from "../axios/axios.js";
import axios from 'axios';

const bookRepository = {
    findAll: async () => {
        return await axiosInstance.get("/books");
    },
    add: async (data) => {
        return await axiosInstance.post("/books/add", data);
    },
    edit: async (id, data) => {
        return await axiosInstance.put(`/books/edit/${id}`, data)
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/books/delete/${id}`)
    },
};

export const fetchBooks = (page, size = 5) => {
    return axios.get(`/api/books/paginated?page=${page}&size=${size}`);
};

export default bookRepository;
