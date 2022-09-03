import * as httpRequests from '~/utils/httpRequest';

export const getEmployees = async () => {
    try {
        const response = await httpRequests.get('employees');
        console.log(response);
        return response;
    } catch (error) {
        console.log(error);
    }
};

export const addEmployee = async (employee) => {
    try {
        const response = await httpRequests.post(`/employees/add`, employee);
        console.log(response);
        return response;
    } catch (error) {
        console.log(error);
    }
};

export const getEmployeeById = async (id) => {
    try {
        const res = await httpRequests.get(`employees/${id}`);
        return res;
    } catch (error) {
        console.log(error);
    }
};

export const updateEmployee = async (id, employee) => {
    try {
        const res = await httpRequests.put(`/employees/${id}`, employee);
        return res;
    } catch (error) {
        console.log(error);
    }
};

export const deleteEmployee = async (id) => {
    try {
        const res = await httpRequests.deleteItem(`/employees/${id}`);
        return res;
    } catch (error) {
        console.log(error);
    }
};
