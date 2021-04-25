import React, { useState, useEffect } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import { DonorService } from "../service/DonorService";
import { Button, TextField } from "@material-ui/core";
import DeleteIcon from "@material-ui/icons/Delete";
const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
});

function createData(colName) {
  return { colName };
}

const cols = [
  createData("Donor Name"),
  createData("Blood Type"),
  createData("City"),
  createData("State"),
  createData("Country"),
  createData("Contact No"),
];

export default function BasicTable() {
  const classes = useStyles();

  const [donorData, setDonorData] = useState([]);
  const [city, setCity] = useState("");
  const [bloodType, setBloodType] = useState("");
  const [filterDonorData, setFilterDonorData] = useState(donorData);
  const [deleteId, setDeleteId] = useState("");

  useEffect(() => {
    getFetch();
  }, []);

  useEffect(() => {
    setFilterDonorData(donorData);
  }, [donorData]);

  const getFetch = async () => {
    const response = await fetch("http://localhost:8080/donors/getAll");
    const jsonData = await response.json();
    console.log(jsonData);
    setDonorData(jsonData);
  };

  useEffect(() => {
    let filteredData = [];
    if (bloodType && city) {
      filteredData = donorData.filter((el) => {
        return (
          el?.city?.toLowerCase().includes(city?.toLowerCase()) &&
          el?.bloodType === bloodType
        );
      });
    } else if (bloodType) {
      filteredData = donorData.filter((el) => {
        return el?.bloodType === bloodType;
      });
    } else if (city) {
      filteredData = donorData.filter((el) => {
        return el?.city?.toLowerCase().includes(city?.toLowerCase());
      });
    } else {
      filteredData = donorData;
    }

    setFilterDonorData(filteredData);
  }, [bloodType, city]);

  const onCityChange = (e) => {
    setCity(e.target.value);
  };

  const onBloodTypeChange = (e) => {
    setBloodType(e.target.value);
  };

  const onDeleteHandler = (id) => {
    const response = fetch(
      "http://localhost:8080/donors/deleteDonor?id=" + id,
      { method: "DELETE" }
    );
    console.log("target: ", id);
    console.log("response: ", response);
    // const jsonData = response.json();
    // console.log(jsonData);
    // setDonorData(jsonData);
  };
  return (
    <>
      <TextField
        fullWidth
        id="standard-basic"
        label="City"
        value={city}
        onChange={onCityChange}
      />
      <TextField
        fullWidth
        id="standard-basic"
        label="Blood Type"
        value={bloodType}
        onChange={onBloodTypeChange}
      />
      <TableContainer component={Paper}>
        <Table className={classes.table} aria-label="simple table">
          <TableHead>
            <TableRow>
              {cols.map((cols) => (
                <TableCell key={cols.colName} component="th" scope="cols">
                  {cols.colName}
                </TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {filterDonorData.map((donor) => (
              <TableRow>
                <TableCell>{donor.fullName}</TableCell>
                <TableCell>{donor.bloodType}</TableCell>
                <TableCell>{donor.city}</TableCell>
                <TableCell>{donor.state}</TableCell>
                <TableCell>{donor.country}</TableCell>
                <TableCell>{donor.contactNo}</TableCell>
                <TableCell>
                  {/* onChange={(e) => onDonorChange(e, "state")} */}
                  <Button
                    onClick={() => {
                      onDeleteHandler(donor.id);
                    }}
                  >
                    <DeleteIcon />
                  </Button>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
}
