import { useState } from 'react';
import { NavLink } from 'react-router-dom';

function SideBar() {
    const [data, setData] = useState([
        {
            title: 'Home',
            to: '/',
        },
        {
            title: 'Add',
            to: '/add-employee',
        },
        {
            title: 'Update',
            to: '/update-employees',
        },
    ]);
    return (
        <nav className="navbar-nav">
            {data.map((item, index) => (
                <NavLink className={(nav) => ('nav-item', { active: nav.isActive })} to={item.to} key={index}>
                    <span>{item.title}</span>
                </NavLink>
            ))}
        </nav>
    );
}

export default SideBar;
