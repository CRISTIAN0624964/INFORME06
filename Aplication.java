public class Aplication {

    // Método para verificar si los símbolos en una cadena están balanceados
    public static boolean symbolBalancing(String s) {
        // Crear una pila para almacenar los símbolos de apertura
        StackLink<Character> stack = new StackLink<>();
        
        // Recorrer cada carácter en la cadena
        for (char c : s.toCharArray()) {
            // Si el carácter es un símbolo de apertura, agregarlo a la pila
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            // Si el carácter es un símbolo de cierre
            else if (c == ')' || c == ']' || c == '}') {
                // Verificar si la pila está vacía (sin un símbolo de apertura correspondiente)
                if (stack.isEmpty()) return false;
                
                // Sacar el símbolo en la cima de la pila
                char top;
                try {
                    top = stack.pop();
                } catch (ExceptionIsEmpty e) {
                    return false;  // En caso de error al hacer pop, la cadena no está balanceada
                }
                
                // Verificar si el símbolo de apertura y cierre coinciden
                if (!matches(top, c)) return false;
            }
        }
        
        // Al final, si la pila está vacía, significa que todos los símbolos están balanceados
        return stack.isEmpty();
    }

    // Método para verificar si un símbolo de apertura y uno de cierre coinciden
    private static boolean matches(char open, char close) {
        // Comparar si los pares de símbolos coinciden correctamente
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
