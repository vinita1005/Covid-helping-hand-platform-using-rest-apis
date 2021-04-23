export const DonorService = () => {
  return {
    RegisterDonor: (donorData) => {
      //we will register user Data here
      console.log("userData", donorData);
      return new Promise((res, rej) => {
        res("hello");
      });
    },
  };
};
