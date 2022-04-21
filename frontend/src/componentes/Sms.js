import React from "react";
import { Link } from "react-router-dom";
import { useParams, useNavigate } from "react-router-dom";
import "./Estilos.css";

/* This is a higher order component that
 *  inject a special prop   to our component.
 */
function withParams(Component) {
  return (props) => (
    <Component {...props} params={useParams()} navigate={useNavigate()} />
  );
}

class Crear extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }
  render() {
    return (

        <div className="container mt-4">
          <div className="card mx-auto">
            <div className="card-header bg-transparent">
              <div className="navbar navbar-expand p-0">
                <ul className="navbar-nav me-auto align-items-center">
                  <li className="nav-item">
                    <a href="#!" className="nav-link">
                      <div
                        className="position-relative"
                        style={{
                          width: "50px",
                          height: "50px",
                          padding: "2px",
                        }}
                      >
                        <img
                          src="https://nextbootstrap.netlify.app/assets/images/profiles/1.jpg"
                          className="img-fluid rounded-circle"
                          alt=""
                        />
                        <span className="position-absolute bottom-0 start-100 translate-middle p-1 bg-success border border-light rounded-circle">
                          <span className="visually-hidden">New alerts</span>
                        </span>
                      </div>
                    </a>
                  </li>
                  <li className="nav-item">
                    <a href="#!" className="nav-link">
                      Nelh
                    </a>
                  </li>
                </ul>
              </div>
            </div>
            <div
              className="card-body p-4"
              style={{ height: "500px", overflow: "auto" }}
            >
              <div className="d-flex align-items-baseline text-end justify-content-end mb-4">
                <div className="pe-2">
                  <div>
                    <div className="card card-text d-inline-block p-2 px-3 m-1">
                      Let me know when you're available?
                    </div>
                  </div>
                  <div>
                    <div className="small">01:13PM</div>
                  </div>
                </div>
                <div className="position-relative avatar">
                  <img
                    src="https://nextbootstrap.netlify.app/assets/images/profiles/2.jpg"
                    className="img-fluid rounded-circle"
                    alt=""
                  />
                  <span className="position-absolute bottom-0 start-100 translate-middle p-1 bg-success border border-light rounded-circle">
                    <span className="visually-hidden">New alerts</span>
                  </span>
                </div>
              </div>
            </div>


            <div className="card-footer bg-white position-absolute w-100 bottom-0 m-0 p-1">
              <div className="input-group">
                <input
                  type="text"
                  className="form-control border-0"
                  placeholder="Write a message..."
                />
                <div className="input-group-text bg-transparent border-0">
                  <button className="btn btn-light text-secondary">
                    <i className="fas fa-paper-plane"></i>
                  </button>
                </div>
              </div>
            </div>

          </div>
        </div>

    );
  }
}

//export default Editar;
export default withParams(Crear);
