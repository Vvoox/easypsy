import URL from "../constants/api";
import axiosInstance from "../request.interpretor";


export const fetchPayment = (numeroCompte: string | undefined) => (dispatch: any) =>
    axiosInstance.get(`${URL.URL.url}/doctor/${numeroCompte}`);
        // .then(({data}) => {
            // console.log(data)
            // dispatch(getPayments(data));
            // return data;
        // }
        // );
