import React from 'react';
import { useParams,useNavigate } from 'react-router-dom';
import { Link } from "react-router-dom";

/* This is a higher order component that 
*  inject a special prop   to our component.
*/ 
function withParams(Component) {
    return props => <Component {...props} params={useParams()} navigate={useNavigate()} />;
  }
  

class Editar extends React.Component {
    constructor(props) {
        super(props);
        this.state={
            datosCargados:false,
            empleado:{}
        }
    }
    componentDidMount(){
        this.consultarDatos();
    }
    cambioValor=(e)=>{
        const state=this.state.empleado;
        state[e.target.name]=e.target.value;
        this.setState({empleado:state});

    }
    enviarDatos=(e)=>{
        e.preventDefault();
        console.log("El formulario fue enviado");
        const{tipo_documento,documento,nombres,apellidos,area,subarea}=this.state.empleado
        console.log(tipo_documento);
        console.log(documento);
        console.log(nombres);
        console.log(apellidos);
        console.log(area);
        console.log(subarea);


        var datosEnviar={
            tipo_documento:tipo_documento,
            documento:documento,
            nombres:nombres,
            apellidos:apellidos,
            area:area,
            subarea:subarea
        }

        fetch('http://localhost:3000/empleados/actualizar/'+this.props.params.id,{
                method:"PUT",
                body:JSON.stringify(datosEnviar),
                headers:{
                    "Content-type":"application/json",
                }
            })
            .then(respuesta=>respuesta.json())
            .then((datosRespuesta=>{
                console.log(datosRespuesta);
                this.props.navigate("/")
            }))

    }
    consultarDatos(){
        fetch('http://localhost:3000/empleados/consultar/'+this.props.params.id)
            .then(respuesta=>respuesta.json())
            .then((datosRespuesta)=>{
                console.log(datosRespuesta);
                this.setState({
                    datosCargados:true,
                    empleado:datosRespuesta
                });
            })
            .catch(console.log)
       
    }
    render() { 

        const{datosCargados, empleado}=this.state

        if(!datosCargados){return(<div>Cargando.....</div>);}
        else{
        return ( <div className="card">
        <div className="card-header">
            Editar
        </div>
        <div className="card-body">
            <form onSubmit={this.enviarDatos}>


                <div className="form-group">
                  <label htmlFor="">Clave: </label>
                  <input type="text" readOnly name="id" id="id" value={empleado._id} className="form-control" placeholder="" aria-describedby="helpId"/>
                  <small id="helpId" className="text-muted">Clave</small>
                </div>

                <div className="form-group">
                  <label htmlFor="">tipo_documentot</label>
                  <input type="text" name="tipo_documento" id="tipo_documento" onChange={this.cambioValor} value={empleado.tipo_documento} className="form-control" placeholder="" aria-describedby="helpId"/>
                  <small id="helpId" className="text-muted">Escriba el tipo_documentot</small>
                </div>

                <div className="form-group">
                  <label htmlFor="">documento</label>
                  <input type="text" name="documento" id="documento" onChange={this.cambioValor} value={empleado.documento} className="form-control" placeholder="" aria-describedby="helpId"/>
                  <small id="helpId" className="text-muted">Escriba el documento</small>
                </div>

                <div className="form-group">
                  <label htmlFor="">nombres</label>
                  <input type="text" name="nombres" id="nombres" onChange={this.cambioValor} value={empleado.nombres} className="form-control" placeholder="" aria-describedby="helpId"/>
                  <small id="helpId" className="text-muted">Escriba el nombres</small>
                </div>

                <div className="form-group">
                  <label htmlFor="">apellidos</label>
                  <input type="text" name="apellidos" id="apellidos" onChange={this.cambioValor} value={empleado.apellidos} className="form-control" placeholder="" aria-describedby="helpId"/>
                  <small id="helpId" className="text-muted">Escriba el apellidos</small>
                </div>

                <div className="form-group">
                  <label htmlFor="">area</label>
                  <input type="text" name="area" id="area" onChange={this.cambioValor} value={empleado.area} className="form-control" placeholder="" aria-describedby="helpId"/>
                  <small id="helpId" className="text-muted">Escriba el area</small>
                </div>

                <div className="form-group">
                  <label htmlFor="">subarea</label>
                  <input type="text" name="subarea" id="subarea" onChange={this.cambioValor} value={empleado.subarea} className="form-control" placeholder="" aria-describedby="helpId"/>
                  <small id="helpId" className="text-muted">Escriba el subarea</small>
                </div>

                <div className="btn-group" role="group" aria-label="">
                    <button type="submit" className="btn btn-success">Actualizar empleado</button>
                    <Link to={"/"} className="btn btn-primary">Cancel</Link>
                </div>

                </form>
        </div>
        <div className="card-footer text-muted">
            
        </div>
    </div> );}
    }
}
 
//export default Editar;
export default withParams(Editar);