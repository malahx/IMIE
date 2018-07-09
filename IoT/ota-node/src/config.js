const config = {};

config.logger = {
    path: "/var/log/gmpvpc/gmpvpc.log",
    type: "tiny"
};

config.api = {
    port: 8080,
    root: "/api",
    device: {
        root: "/device",
        register: "/register",
        unregister: "/unregister",
        info: "/info",
        version: "/version",
    }
};

config.dao = {
    uri: "postgres://gmpvpc:gmpvpc@localhost:5432/gmpvpc",
    force: true
};

config.version = {
    version: 1
};

export default config;