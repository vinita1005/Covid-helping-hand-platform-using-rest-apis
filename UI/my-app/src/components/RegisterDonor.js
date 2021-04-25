import React, { useEffect, useState } from "react";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import Avatar from "@material-ui/core/Avatar";
import ArrowBackIcon from "@material-ui/icons/ArrowBack";
import { DonorService } from "../service/DonorService";
import CardActions from "@material-ui/core/CardActions";
import { ListItem, TextField } from "@material-ui/core";
import Select from "@material-ui/core/Select";
import MenuItem from "@material-ui/core/MenuItem";
import InputLabel from "@material-ui/core/InputLabel";
import { makeStyles } from "@material-ui/core/styles";
import List from "@material-ui/core/List";

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
  root: {
    width: "100%",
  },
});

export default function UserRegister({ onUserStage }) {
  const classes = useStyles();
  const IntialUserData = {
    fullName: "",
    city: "",
    state: "",
    country: "",
    contactNo: "",
    fullAddress: "",
    bloodType: "",
  };

  const [donor, setDonor] = useState(IntialUserData);
  const [isValid, setIsValid] = useState(true);
  const {
    fullName,
    city,
    bloodType,
    state,
    country,
    contactNo,
    fullAddress,
  } = donor;

  const onRegisterHandler = () => {
    DonorService().RegisterDonor(donor);
    return onUserStage(2);
  };

  const onDonorChange = (event, label) => {
    let value = event.target.value;
    let updateDonor = { ...donor };
    updateDonor[label] = value;
    setDonor(updateDonor);
  };

  useEffect(() => {
    if (fullName && city && bloodType) {
      setIsValid(false);
    } else {
      setIsValid(true);
    }
  }, [fullName, city, bloodType]);

  const onClearHandler = () => {
    setDonor(IntialUserData);
  };

  return (
    <div>
      <Card>
        <div>
          <Avatar onClick={() => onUserStage(0)}>
            <ArrowBackIcon />
          </Avatar>
          <Typography>
            <h2>Register Donor information</h2>
          </Typography>
        </div>
        <CardContent>
          <List
            component="nav"
            className={classes.root}
            aria-label="mailbox folders"
          >
            <ListItem>
              <TextField
                fullWidth
                id="standard-basic"
                label="Donor Name"
                value={fullName}
                required
                onChange={(e) => onDonorChange(e, "fullName")}
              />
            </ListItem>
            <ListItem>
              <InputLabel id="bloodType" required>
                Blood Type
              </InputLabel>
              <Select
                labelId="bloodType"
                id="standard-basic"
                value={bloodType}
                required
                onChange={(e) => onDonorChange(e, "bloodType")}
              >
                <MenuItem value={"A+"}>A+</MenuItem>
                <MenuItem value={"A-"}>A-</MenuItem>
                <MenuItem value={"B+"}>B+</MenuItem>
                <MenuItem value={"B-"}>B-</MenuItem>
                <MenuItem value={"O+"}>O+</MenuItem>
                <MenuItem value={"O-"}>O-</MenuItem>
              </Select>
            </ListItem>
            <ListItem>
              <TextField
                fullWidth
                id="standard-basic"
                label="City"
                value={city}
                required
                onChange={(e) => onDonorChange(e, "city")}
              />
            </ListItem>
            <ListItem>
              <TextField
                fullWidth
                id="standard-basic"
                label="State"
                value={state}
                onChange={(e) => onDonorChange(e, "state")}
              />
            </ListItem>
            <ListItem>
              <TextField
                fullWidth
                id="standard-basic"
                label="Country"
                value={country}
                onChange={(e) => onDonorChange(e, "country")}
              />
            </ListItem>
            <ListItem>
              <TextField
                fullWidth
                id="standard-basic"
                label="Contact No"
                value={contactNo}
                onChange={(e) => onDonorChange(e, "contactNo")}
              />
            </ListItem>
            <ListItem>
              <TextField
                fullWidth
                id="standard-basic"
                label="Complete Address"
                value={fullAddress}
                onChange={(e) => onDonorChange(e, "fullAddress")}
              />
            </ListItem>
            <ListItem>
              <Button variant="outlined" onClick={onClearHandler}>
                Clear
              </Button>
            </ListItem>
          </List>
        </CardContent>
        <CardActions>
          <Button
            disabled={isValid}
            onClick={onRegisterHandler}
            variant="outlined"
            size="large"
          >
            Register as Plasma Donor
          </Button>
        </CardActions>
      </Card>
    </div>
  );
}
