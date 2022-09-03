import { NavigationType, useLocation } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import * as employeeService from '~/service/EmployeeService';

function UpdateEmployee() {
    const location = useLocation();
    const navigate = useNavigate();

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [emailId, setEmailId] = useState('');
    const [employee, setEmployee] = useState({
        firstName: firstName,
        lastName: lastName,
        emailId: emailId,
    });
    let id = null;
    if (location.state !== null) {
        id = location.state.userId;
    }

    useEffect(() => {
        const fetchApi = async (id) => {
            const result = await employeeService.getEmployeeById(id);
            setEmployee(result);
        };

        if (location.state !== null) {
            fetchApi(id);
        }
    }, [id, location.state]);

    const firstNameChange = (e) => {
        const value = e.target.value;
        employee.firstName = value;
        setFirstName(value);
        setEmployee(employee);
    };

    const lastNameChange = (e) => {
        const value = e.target.value;
        employee.lastName = value;
        setLastName(value);
        setEmployee(employee);
    };

    const emailChange = (e) => {
        const value = e.target.value;
        employee.emailId = value;
        setEmailId(value);
        setEmployee(employee);
    };

    const updateEmployee = () => {
        try {
            if (location.state !== null) {
                employeeService.updateEmployee(id, employee);
            } else {
                employeeService.addEmployee(employee);
            }
            navigate('/employees', NavigationType.Pop);
        } catch (error) {
            console.log(error);
        }
    };

    const getTitle = () => {
        if (location.state !== null) {
            return <h2 className="text-center">Update</h2>;
        } else {
            return <h2 className="text-center">Add</h2>;
        }
    };

    return (
        <div>
            <div className="container">
                {getTitle()}
                <form className="form-horizontal">
                    <div className="form-group">
                        <label className="col-sm-2 control-label">First Name</label>
                        <input
                            type="text"
                            className="form-control"
                            placeholder="First Name"
                            value={employee.firstName}
                            onChange={firstNameChange}
                        />
                    </div>

                    <div className="form-group">
                        <label className="col-sm-2 control-label">Last Name</label>
                        <input
                            type="text"
                            className="form-control"
                            placeholder="Last Name"
                            value={employee.lastName}
                            onChange={lastNameChange}
                        />
                    </div>

                    <div className="form-group">
                        <label className="col-sm-2 control-label">Email</label>
                        <input
                            type="text"
                            className="form-control"
                            placeholder="Email"
                            value={employee.emailId}
                            onChange={emailChange}
                        />
                    </div>

                    <button className="btn btn-primary" onClick={updateEmployee}>
                        Save
                    </button>
                    <button
                        className="btn btn-danger"
                        onClick={() => {
                            navigate('/');
                        }}
                    >
                        Cancel
                    </button>
                </form>
            </div>
        </div>
    );
}

export default UpdateEmployee;
