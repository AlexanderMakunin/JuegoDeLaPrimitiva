
# JuegoDeLaPrimitiva

Este repositorio contiene la implementación del **Juego de La Primitiva**.

---

## Normas de contribución

### Pull Requests

- **Regla importante**:  
  Los Pull Requests deben ser revisados y aprobados por otro compañero. No está permitido que el autor del PR apruebe su propio trabajo.
- Cada PR debe pasar las verificaciones automáticas y cumplir con los estándares establecidos antes de que pueda ser fusionado.


. **Verificación de compilación**:
   - Antes de aceptar un PR, se verificará que todo el código compile correctamente.
   - Si hay errores de compilación, el PR no podrá ser fusionado hasta que se resuelvan.

### ¿Dudas o problemas?

Si tienes dudas sobre las reglas de estilo, el flujo de trabajo, o necesitas ayuda con cualquier otra cosa, **no dudes en preguntar**. ¡Somos un equipo amable y siempre estamos dispuestos a ayudar!

---

## Cómo contribuir

Sigue estos pasos para contribuir al proyecto:

1. Crea una nueva rama desde `main` (nombra la rama de forma descriptiva; por ejemplo, `feature-X` o `bugfix-Y`).
2. Realiza los cambios necesarios en tu rama.
3. Asegúrate de que tu código pase todos los checks (CheckStyle, compilación y cualquier prueba automatizada).
4. Envía un Pull Request desde tu rama hacia `main`.
5. Espera a que otro compañero revise y apruebe tu Pull Request.
6. Una vez aprobado y tras pasar todas las verificaciones, tu PR podrá ser fusionado con la rama principal `main`.

**Regla de oro del flujo de trabajo:** Mantén la rama principal limpia y asegúrate de que solo contenga código funcional y probado.

---

## Desarrollo

Para llevar un seguimiento de las tareas pendientes, el progreso actual y las implementaciones completadas, te recomendamos consultar el tablero Kanban en la sección **Projects** de este repositorio.

---

## Recursos útiles

### Sobre el juego de La Primitiva
- La Primitiva es un juego de lotería en el que se seleccionan 6 números del 1 al 49. Existen premios según el número de aciertos, y también se incluye un "número complementario" y un "reintegro". Este último es generado aleatoriamente y es clave para ciertos premios.
- **Reglas básicas de La Primitiva**: 
  - Escoge una combinación de 6 números entre el 1 y el 49.
  - En un sorteo se seleccionan al azar 6 números más un número complementario.
  - Si tus 6 números coinciden con los seleccionados en el sorteo, ganas el premio mayor (también llamado "categoría especial").
- Más información sobre cómo funciona La Primitiva: [Reglas oficiales de La Primitiva](https://juegos.loteriasyapuestas.es/jugar/la-primitiva/apuesta/?access=headercms&lang=es)

### Recursos sobre Programación Orientada a Objetos (POO)
- **Conceptos básicos de POO**: 
  - Clases y Objetos
  - Métodos y Atributos
  - Encapsulamiento, Herencia, Polimorfismo, Abstracción
  - [POO en Java](https://www.w3schools.com/java/java_oop.asp)
- Documentación oficial de Oracle sobre conceptos relacionados con Java y la POO: [The Java Tutorials - Object-Oriented Programming](https://docs.oracle.com/javase/tutorial/java/concepts/)
- Explicación breve sobre **cómo modelar un problema usando POO**: 
  - Identifica las entidades principales (estas serán tus clases).
  - Define los atributos y comportamientos de estas entidades (atributos = campos o variables, comportamientos = métodos).
  - Relaciona las clases entre sí mediante herencia o composición según sea necesario.

### Uso correcto de GitHub y flujo de trabajo en equipo
- **Ramas y Pull Requests**: Siempre trabaja en ramas separadas y realiza PRs hacia la rama principal (`main`). Esto asegura que el código no funcional no llegue al repositorio central.
- **Commits limpios y descriptivos**: Cada commit debe tener un mensaje claro que explique los cambios realizados. Ejemplo de un buen mensaje de commit:
  ```
  Añadida funcionalidad para calcular premios según los aciertos
  ```
- **Resolución de conflictos**: Cuando haya conflictos al fusionar cambios, estos deben resolverse primero en tu rama local antes de realizar el PR.
- **Resumen del flujo de trabajo**: 
  1. Crea una rama nueva para tu tarea.
  2. Realiza los cambios en esa rama y realiza commits descriptivos.
  3. Sube la rama a GitHub y solicita el Pull Request.
  4. Revisa comentarios y realiza ajustes si es necesario.
  5. Cuando todo esté correcto, otro compañero aprobará tu PR y se podrá fusionar.

- Recursos adicionales:
  - Guía oficial de GitHub: [Trabajar con ramas en GitHub](https://docs.github.com/es/get-started/quickstart/github-flow)
  - Tutorial sobre cómo usar Git y GitHub de manera efectiva: [Git & GitHub para principiantes](https://rogerdudler.github.io/git-guide/index.es.html)
  -  Modelos de Github como apoyo en el aprendizaje y resolución de errores: [Github Models](https://github.com/marketplace/models)

---

Gracias por contribuir al proyecto. Con tu ayuda, construiremos una implementación excepcional del Juego de La Primitiva. Si tienes preguntas o dudas, no dudes en preguntar. ¡Juntos hacemos un gran trabajo! 🚀
