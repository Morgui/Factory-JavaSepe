@author Luz Divina Delgado Castañeda

La práctica está totalmente implementada y compila correctamente. Realizada con Java SE 8.

He creado las clases correspondientes a OverrideException y NotFoundException dentro del package factoria.exception para que la clase Test no de error y compile, importándolos en las clases necesarias que las van a usar.

También he realizado cambios en el método getWorker de la clase Factory, porque había incongruencias con lo que pedía la documentación y la clase Test, no comprobando los DNI con su letra sino solo los números. Lo he solventado al modificar el parámetro pDni:int del método getWorker por un String.

