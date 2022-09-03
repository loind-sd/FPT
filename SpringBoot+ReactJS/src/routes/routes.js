import config from '~/config';

// Layouts
import { DefaultLayout } from '~/layout/defaultLayout';

// Pages
import ListEmployee from '~/component/listEmployee/ListEmployee';
import UpdateEmployee from '~/component/updateEmployee/UpdateEmployee';

// Public routes
const publicRoutes = [
    { path: config.routes.home, component: ListEmployee },
    { path: config.routes.home2, component: ListEmployee },
    { path: config.routes.add, component: UpdateEmployee },
    { path: config.routes.update, component: UpdateEmployee },
];

const privateRoutes = [];

export { publicRoutes, privateRoutes };
