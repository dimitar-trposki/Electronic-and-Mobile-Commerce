import React from 'react';
import InfoIcon from '@mui/icons-material/Info';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import {Box, Button, Card, CardActions, CardContent, Typography} from "@mui/material";

const Book = ({book}) => {
    return (
        <Card sx={{boxShadow: 3, borderRadius: 2, p: 1}}>
            <CardContent>
                <Typography variant="h5">{book.name}</Typography>
                <Typography variant="subtitle2">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aperiam assumenda blanditiis cum
                    ducimus enim modi natus odit quibusdam veritatis.
                </Typography>
                <Typography variant="h6"
                            sx={{textAlign: "right", fontSize: "1.25rem"}}>{book.author}</Typography>
                <Typography variant="body2" sx={{textAlign: "right"}}>{book.avalaiableCopies} book copies
                    available</Typography>
            </CardContent>
            <CardActions sx={{justifyContent: "space-between"}}>
                <Button size="small" color="info" startIcon={<InfoIcon/>}>Info</Button>
                <Box>
                    <Button size="small" color="warning" startIcon={<EditIcon/>} sx={{mr: "0.25rem"}}>Edit</Button>
                    <Button size="small" color="error" startIcon={<DeleteIcon/>}>Delete</Button>
                </Box>
            </CardActions>
        </Card>
    );
};

export default Book;