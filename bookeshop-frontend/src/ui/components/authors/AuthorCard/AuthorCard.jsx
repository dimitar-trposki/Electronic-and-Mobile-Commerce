import InfoIcon from '@mui/icons-material/Info';
import {Button, Card, CardActions, CardContent, Typography} from "@mui/material";

import {useNavigate} from "react-router";

const AuthorCard = ({author}) => {
    const navigate = useNavigate();

    return (
        <>
            <Card sx={{boxShadow: 3, borderRadius: 2, p: 1}}>
                <CardContent>
                    <Typography variant="h5">{author.name + " " + author.surname}</Typography>
                    <Typography variant="body1"
                                sx={{textAlign: "right", fontSize: "1.25rem"}}>{author.countryName}</Typography>
                </CardContent>
                <CardActions sx={{justifyContent: "space-between"}}>
                    <Button
                        size="small"
                        color="info"
                        startIcon={<InfoIcon/>}
                        onClick={() => navigate(`/authors/${author.id}`)}
                    >
                        Info
                    </Button>
                </CardActions>
            </Card>
        </>
    );
};

export default AuthorCard;