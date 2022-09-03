import Footer from '../footer';
import PropTypes from 'prop-types';
import Header from '../header';
import SideBar from '../sidebar/SideBar';

function DefaultLayout({ children }) {
    return (
        <div>
            <Header />
            <div className="container">
                <SideBar />
                <div>{children}</div>
                <Footer />
            </div>
        </div>
    );
}

DefaultLayout.propTypes = {
    children: PropTypes.node,
};

export default DefaultLayout;
