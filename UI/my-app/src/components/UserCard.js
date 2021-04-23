import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import Avatar from "@material-ui/core/Avatar";

import Donor from "../assets/donor.png";
import Patient from "../assets/patient.jpeg";

const useStyles = makeStyles({
    root: {
      display: "flex",
      flex: 1,
      justifyContent: "center",
      flexDirection: "column",
    },
    title: {
      fontSize: 24,
      fontFamily: "bold",
    },
    cardButton: {
      minWidth: 275,
      justifyContent: "center",
      alignItems: "center",
      padding: 32,
    },
    avatarStle: {
      height: 120,
      width: 120,
      padding: 16,
      margin: 16,
    },
  });

  export default function UserCard({ title, iconType, onSelect }) {
    const classes = useStyles();
    return (
      <Card className={classes.root} variant="outlined">
        <Button onClick={onSelect} className={classes.cardButton}>
          <CardContent>
            <Typography className={classes.title} gutterBottom>
              {title}
            </Typography>
  
            {iconType === "donor" ? (
              <Avatar className={classes.avatarStle} src={Donor} />
            ) : (
              <Avatar className={classes.avatarStle} src={Patient} />
            )}
          </CardContent>
        </Button>
      </Card>
    );
  }