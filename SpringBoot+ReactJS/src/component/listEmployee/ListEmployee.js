import { useEffect, useState } from 'react';
import { Link, NavigationType, useNavigate } from 'react-router-dom';

import Tippy from '@tippyjs/react';
import HeadlessTippy from '@tippyjs/react/headless';
import 'tippy.js/dist/tippy.css'; // optional
import * as EmployeeService from '~/service/EmployeeService';

function ListEmployee() {
    const [employees, setEmployees] = useState([]);
    const [lastDeletedTitle, setLastDelete] = useState('');
    const tippyData = [
        {
            title: 'English',
            children: {
                title: 'Language',
                data: [
                    {
                        type: 'language',
                        code: 'en',
                        title: 'English',
                    },
                    {
                        type: 'language',
                        code: 'vi',
                        title: 'Tiếng Việt',
                    },
                ],
            },
        },
        {
            title: 'Feedback and help',
            to: '/feedback',
        },
        {
            title: 'Keyboard shortcuts',
        },
    ];

    const navigate = useNavigate();

    useEffect(() => {
        const fetchApi = async () => {
            let result = await EmployeeService.getEmployees();
            if (result === undefined) {
                result = [];
            }
            setEmployees(result);
        };

        if (lastDeletedTitle !== '') {
            setLastDelete('');
            fetchApi();
        }

        fetchApi();
    }, [lastDeletedTitle]);

    const updateEmployee = (id) => {
        navigate(`/update-employees/${id}`, {
            state: {
                userId: id,
            },
        });
    };

    const deleteEmployee = async (id) => {
        await EmployeeService.deleteEmployee(id);
        setLastDelete('Deleted');
    };

    const renderResult = () => {
        return tippyData.map((item, index) => {
            return (
                <div key={index}>
                    <Link to={item.to === undefined ? '' : item.to}>{item.title}</Link>
                </div>
            );
        });
    };

    return (
        <div>
            <h2 className="text-center">Employees</h2>
            <HeadlessTippy
                interactive
                delay={[100, 100]}
                offset={[12, 8]}
                placement="bottom-end"
                hideOnClick={true}
                render={renderResult}
                appendTo={document.body}
            >
                <button>more </button>
            </HeadlessTippy>

            <div>
                <Tippy content="Add">
                    <Link to="/add-employee">
                        <button className="btn btn-primary">Add</button>
                    </Link>
                </Tippy>
            </div>
            <Tippy content="Alo" placement="right-end">
                <button>Alo</button>
            </Tippy>
            <div className="row">
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Action</th>
                        </tr>
                    </thead>

                    <tbody>
                        {employees.map((employee) => (
                            <tr key={employee.id}>
                                <td>{employee.firstName}</td>
                                <td>{employee.emailId}</td>
                                <td>
                                    <button className="btn btn-info" onClick={() => updateEmployee(employee.id)}>
                                        Update
                                    </button>
                                    <button className="btn btn-danger" onClick={() => deleteEmployee(employee.id)}>
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default ListEmployee;
