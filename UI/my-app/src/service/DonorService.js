export const DonorService = () => {
  return {
    RegisterDonor: (donorData) => {
      //we will register user Data here
      console.log("userData", donorData);
      const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(donorData)
      };
      fetch('http://localhost:8080/donors/addDonor', requestOptions)
        .then(response => response.json())
        .then(donorData => console.log(donorData));
    },

    GreetDonor: () => {
      console.log("Calling get greeting");
      fetch('http://localhost:8080/donors/greeting')
        .then(response => response.json())
        .then(data => console.log(data));
    },
  };
};
