var vectorCursos = new Array(2);

vectorCursos[0] = 0;
vectorCursos[1] = 0;

function contarCursos(valor){
	let cadena = "";
	vectorCursos[valor] += 1;
	
	cadena += "Cursos nuevos creados para Primaria: " + vectorCursos[0] + "\n";
	cadena += "Cursos nuevos creados para Secundaria: " + vectorCursos[1] + "\n";
	alert(cadena);
}