function cargarPolizas() {
  fetch("http://localhost:8080/polizas")
    .then((response) => {
      if (!response.ok) {
        throw new Error("No se pudo obtener la información");
      }
      return response.json();
    })
    .then((polizas) => {
      const tbody = document.querySelector("#tabla-polizas tbody");
      tbody.innerHTML = ""; // Limpiar tabla

      polizas.forEach((poliza) => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${poliza.clave}</td>
            <td>${poliza.tipo}</td>
            <td>$${poliza.monto.toFixed(2)}</td>
            <td>${poliza.descripcion}</td>
            <td>${poliza.curpCliente}</td>
          `;
        tbody.appendChild(row);
      });
    })
    .catch((error) => {
      alert("Error al cargar las pólizas: " + error.message);
    });
}

function buscarPoliza(event) {
  event.preventDefault();

  const clave = document.getElementById("clavePoliza").value.trim();
  const url = `http://localhost:8080/polizas/${clave}`;

  fetch(url)
    .then((response) => {
      if (!response.ok) {
        throw new Error("Póliza no encontrada");
      }
      return response.json();
    })
    .then((poliza) => {
      const resultado = document.getElementById("resultado-poliza");
      resultado.innerHTML = `
          <p><strong>Clave:</strong> ${poliza.clave}</p>
          <p><strong>Tipo:</strong> ${poliza.tipo}</p>
          <p><strong>Monto:</strong> $${poliza.monto.toFixed(2)}</p>
          <p><strong>Descripción:</strong> ${poliza.descripcion}</p>
          <p><strong>CURP Cliente:</strong> ${poliza.curpCliente}</p>
        `;
    })
    .catch((error) => {
      document.getElementById("resultado-poliza").innerText = error.message;
    });
}

function agregarPoliza(event) {
  event.preventDefault();

  const clave = document.getElementById("nuevaClave").value.trim();
  const tipo = document.getElementById("nuevoTipo").value.trim();
  const monto = parseFloat(document.getElementById("nuevoMonto").value);
  const descripcion = document.getElementById("nuevaDescripcion").value.trim();
  const curpCliente = document.getElementById("nuevoCurp").value.trim();

  const url = `http://localhost:8080/polizas/${clave}/${tipo}/${monto}/${descripcion}/${curpCliente}`;

  const poliza = {
    clave,
    tipo,
    monto,
    descripcion,
    curpCliente,
  };

  fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(poliza),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Error al agregar póliza");
      }
      return response.json();
    })
    .then((data) => {
      document.getElementById("resultado-agregar").innerText =
        "Póliza agregada correctamente";
      cargarPolizas(); // Recarga la tabla con las nuevas pólizas
    })
    .catch((error) => {
      document.getElementById("resultado-agregar").innerText =
        "Error: " + error.message;
    });
}

function eliminarPoliza(event) {
  event.preventDefault();

  const clave = document.getElementById("claveEliminar").value.trim();
  const url = `http://localhost:8080/polizas/${clave}`;

  fetch(url, {
    method: "DELETE",
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("No se pudo eliminar la póliza");
      }
      document.getElementById(
        "resultado-eliminar"
      ).innerText = `Póliza ${clave} eliminada correctamente`;
      cargarPolizas(); // Actualiza la tabla
    })
    .catch((error) => {
      document.getElementById("resultado-eliminar").innerText =
        "Error: " + error.message;
    });
}
