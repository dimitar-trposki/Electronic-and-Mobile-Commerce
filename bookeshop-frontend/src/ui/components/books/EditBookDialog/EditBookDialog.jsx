import React, {useState} from 'react';
import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogTitle,
    FormControl,
    InputLabel, MenuItem, Select,
    TextField
} from "@mui/material";

const EditBookDialog = ({open, onClose, book, onEdit}) => {
    const [formData, setFormData] = useState({
        "name": book.name,
        "author": book.author,
        "category": book.category,
        "availableCopies": book.availableCopies,
    });

    const categories = [
        {value: 'NOVEL', label: 'Novel'},
        {value: 'THRILLER', label: 'Thriller'},
        {value: 'HISTORY', label: 'History'},
        {value: 'FANTASY', label: 'Fantasy'},
        {value: 'BIOGRAPHY', label: 'Biography'},
        {value: 'CLASSICS', label: 'Classics'},
        {value: 'DRAMA', label: 'Drama'}
    ];

    const handleChange = (event) => {
        const {name, value} = event.target;
        setFormData({...formData, [name]: value});
    };

    const handleSubmit = () => {
        onEdit(book.id, formData);
        setFormData(formData);
        onClose();
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Edit Book</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    label="Name"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                    fullWidth
                />
                <TextField
                    margin="dense"
                    label="Available Copies"
                    name="availableCopies"
                    type="number"
                    value={formData.availableCopies}
                    onChange={handleChange}
                    fullWidth
                />
                <FormControl fullWidth margin="dense">
                    <InputLabel>Category</InputLabel>
                    <Select
                        name="category"
                        value={formData.category}
                        onChange={handleChange}
                        label="Category"
                        variant="outlined">
                        {categories.map((category) => (
                            <MenuItem item key={category.value} value={category.value}>{category.label}</MenuItem>
                        ))}
                    </Select>
                </FormControl>
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button onClick={handleSubmit} variant="contained" color="warning">Edit</Button>
            </DialogActions>
        </Dialog>
    );
};

export default EditBookDialog;