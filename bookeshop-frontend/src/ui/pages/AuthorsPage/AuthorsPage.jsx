import {Box, CircularProgress} from "@mui/material";
import useAuthors from "../../../hooks/useAuthors.js";
import AuthorsGrid from "../../components/authors/AuthorsGrid/AuthorsGrid.jsx";

const AuthorsPage = () => {
    const {authors, loading} = useAuthors();

    return (
        <>
            <Box className="books-box">
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress/>
                    </Box>
                )}
                {!loading &&
                    <>
                        {/*<Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>*/}
                        {/*    <Button variant="contained" color="primary" onClick={() => setAddBookDialogOpen(true)}>*/}
                        {/*        Add Book*/}
                        {/*    </Button>*/}
                        {/*</Box>*/}
                        <AuthorsGrid authors={authors}/>
                    </>
                }
            </Box>
            {/*<AddBookDialog*/}
            {/*    open={addBookDialogOpen}*/}
            {/*    onClose={() => setAddBookDialogOpen(false)}*/}
            {/*    onAdd={onAdd}*/}
            {/*/>*/}
        </>
    );
};

export default AuthorsPage;