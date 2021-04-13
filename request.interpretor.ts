// @ts-ignore
import axios, {AxiosRequestConfig} from "axios";
const axiosInstance = axios.create();

const interceptor = axiosInstance.interceptors.request.use(
    (config: AxiosRequestConfig) => {
        // console.log(authState.token)
        // config.headers.HTTP2_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN='*'
        // config.headers.Authorization= `Bearer ${authState.token}`
        return config;
    },
    // error => Promise.reject(error)
);

export default axiosInstance;