import java.util.*;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class ProyectoDiscreta {
    static Scanner sc = new Scanner(System.in);

    // ========================= SECCIÓN CONJUNTOS =========================
    static Set<String> conjuntoA = null;
    static Set<String> conjuntoB = null;

    public static void menuConjuntos() {
        System.out.println("\n--- CONJUNTOS ---");
        System.out.println("Un conjunto es una colección de elementos sin repetición.");
        System.out.println("Operaciones básicas:");
        System.out.println("1. Unión (A U B)");
        System.out.println("2. Intersección (A ∩ B)");
        System.out.println("3. Diferencia (A - B o B - A)");

        boolean salir = false;

        while (!salir) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("a. Crear conjuntos");
            System.out.println("b. Operaciones básicas");
            System.out.println("c. Regresar al menú principal");
            String opcion = sc.nextLine();

            switch (opcion.toLowerCase()) {
                case "a": crearConjuntos(); break;
                case "b":
                    if (conjuntoA == null || conjuntoB == null)
                        System.out.println(" Primero debe crear los conjuntos.");
                    else operacionesConjuntos();
                    break;
                case "c": salir = true; break;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    public static void crearConjuntos() {
        conjuntoA = new HashSet<>();
        conjuntoB = new HashSet<>();

        System.out.println("¿Cuántos elementos desea ingresar? (1-20): ");
        int n = readInt();
        if (n < 1 || n > 20) { System.out.println("Número fuera de rango."); return; }

        System.out.println("¿Ingreso manual (1) o aleatorio (2)?");
        int modo = readInt();

        if (modo == 1) {
            System.out.println("Ingrese los elementos del Conjunto A:");
            for (int i = 0; i < n; i++) conjuntoA.add(sc.nextLine());
            System.out.println("Ingrese los elementos del Conjunto B:");
            for (int i = 0; i < n; i++) conjuntoB.add(sc.nextLine());
        } else {
            Random rand = new Random();
            for (int i = 0; i < n; i++) conjuntoA.add(String.valueOf(rand.nextInt(100)));
            for (int i = 0; i < n; i++) conjuntoB.add(String.valueOf(rand.nextInt(100)));
        }

        System.out.println("Conjunto A: " + conjuntoA);
        System.out.println("Conjunto B: " + conjuntoB);
    }

    public static void operacionesConjuntos() {
        System.out.println("\nSeleccione la operación:");
        System.out.println("1. Unión");
        System.out.println("2. Intersección");
        System.out.println("3. Diferencia");
        int opcion = readInt();

        Set<String> resultado = new HashSet<>();
        switch (opcion) {
            case 1:
                resultado.addAll(conjuntoA);
                resultado.addAll(conjuntoB);
                System.out.println("Unión: " + resultado);
                break;
            case 2:
                resultado.addAll(conjuntoA);
                resultado.retainAll(conjuntoB);
                System.out.println("Intersección: " + resultado);
                break;
            case 3:
                System.out.println("¿Desea A - B (1) o B - A (2)?");
                int tipo = readInt();
                if (tipo == 1) {
                    resultado.addAll(conjuntoA);
                    resultado.removeAll(conjuntoB);
                    System.out.println("A - B: " + resultado);
                } else {
                    resultado.addAll(conjuntoB);
                    resultado.removeAll(conjuntoA);
                    System.out.println("B - A: " + resultado);
                }
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    // ========================= SECCIÓN COMBINATORIA =========================
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }

    public static void menuCombinatoria() {
        System.out.println("\n--- COMBINATORIA ---");
        System.out.println("Permutaciones y combinaciones de elementos.");

        boolean salir = false;
        while (!salir) {
            System.out.println("\nSeleccione:");
            System.out.println("a. Permutaciones simples");
            System.out.println("b. Combinaciones simples");
            System.out.println("c. Permutaciones con repetición");
            System.out.println("d. Combinaciones con repetición");
            System.out.println("e. Regresar");
            String opcion = sc.nextLine();

            int n, r;
            switch (opcion.toLowerCase()) {
                case "a":
                    System.out.print("Ingrese n: "); n = readInt();
                    System.out.print("Ingrese r: "); r = readInt();
                    if (r > n) System.out.println("r no puede ser mayor que n.");
                    else System.out.println("Permutaciones: " + (factorial(n) / factorial(n - r)));
                    break;
                case "b":
                    System.out.print("Ingrese n: "); n = readInt();
                    System.out.print("Ingrese r: "); r = readInt();
                    if (r > n) System.out.println("r no puede ser mayor que n.");
                    else System.out.println("Combinaciones: " + (factorial(n) / (factorial(r) * factorial(n - r))));
                    break;
                case "c":
                    System.out.print("Ingrese n: "); n = readInt();
                    System.out.print("Ingrese r: "); r = readInt();
                    System.out.println("Permutaciones con repetición: " + Math.pow(n, r));
                    break;
                case "d":
                    System.out.print("Ingrese n: "); n = readInt();
                    System.out.print("Ingrese r: "); r = readInt();
                    System.out.println("Combinaciones con repetición: " + (factorial(n + r - 1) / (factorial(r) * factorial(n - 1))));
                    break;
                case "e":
                    salir = true; break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // ========================= SECCIÓN RECURSIVIDAD =========================
    public static void menuRecursividad() {
        System.out.println("\n--- RECURSIVIDAD ---");
        System.out.println("Ejemplos de funciones recursivas.");

        boolean salir = false;
        while (!salir) {
            System.out.println("\nSeleccione:");
            System.out.println("a. Factorial");
            System.out.println("b. Suma recursiva (A + B)");
            System.out.println("c. Serie Fibonacci en pirámide");
            System.out.println("d. Regresar");
            String opcion = sc.nextLine();

            switch (opcion.toLowerCase()) {
                case "a":
                    System.out.print("Ingrese número: "); int num = readInt();
                    System.out.println("Factorial: " + factorialRecursivo(num));
                    break;
                case "b":
                    System.out.print("Ingrese A: "); int a = readInt();
                    System.out.print("Ingrese B: "); int b = readInt();
                    System.out.println("Resultado: " + sumaRecursiva(a, b));
                    break;
                case "c":
                    System.out.print("Ingrese n (5-20): "); int n = readInt();
                    fibonacciPiramide(n);
                    break;
                case "d": salir = true; break;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    public static long factorialRecursivo(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursivo(n - 1);
    }

    public static int sumaRecursiva(int a, int b) {
        if (b == 0) return a;
        return sumaRecursiva(a + 1, b - 1);
    }

    public static void fibonacciPiramide(int n) {
        if (n < 2) { System.out.println("n debe ser al menos 2."); return; }
        int[] fib = new int[n];
        fib[0] = 0; fib[1] = 1;
        for (int i = 2; i < n; i++) fib[i] = fib[i - 1] + fib[i - 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) System.out.print(fib[j] + " ");
            System.out.println();
        }
    }

    // ========================= SECCIÓN NÚMEROS PRIMOS =========================
    public static void menuPrimos() {
        System.out.println("\n--- NÚMEROS PRIMOS ---");
        System.out.print("Ingrese un número (<1000): ");
        int num = readInt();
        if (num < 2 || num >= 1000) { System.out.println("Rango inválido."); return; }

        boolean primo = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            System.out.printf("Comprobando %d ÷ %d ...\n", num, i);
            if (num % i == 0) { primo = false; break; }
        }
        System.out.println(num + (primo ? " es primo." : " no es primo."));
    }

    // ========================= SECCIÓN MCD Y MCM =========================
    public static void menuMcdMcm() {
        System.out.println("\n--- MCD y MCM ---");
        System.out.print("Ingrese A: "); int a = readInt();
        System.out.print("Ingrese B: "); int b = readInt();

        int gcd = gcd(Math.abs(a), Math.abs(b));
        long lcm = (a == 0 || b == 0) ? 0 : (Math.abs((long)a * (long)b) / gcd);
        System.out.println("MCD = " + gcd);
        System.out.println("MCM = " + lcm);

        System.out.println("\nPasos (algoritmo de Euclides):");
        printEuclidesSteps(Math.abs(a), Math.abs(b));
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void printEuclidesSteps(int a, int b) {
        int x = a, y = b;
        while (y != 0) {
            int q = x / y;
            int r = x % y;
            System.out.println(x + " = " + q + " * " + y + " + " + r);
            x = y; y = r;
        }
        System.out.println("MCD = " + x);
    }

    // ========================= SECCIÓN MATRICES =========================
    public static void menuMatrices() {
        System.out.println("\n--- MATRICES ---");
        System.out.print("Tamaño (3-5): ");
        int n = readInt();
        if (n < 3 || n > 5) { System.out.println("Tamaño inválido."); return; }

        int[][] A = generateRandomMatrix(n, 1, 10);
        int[][] B = generateRandomMatrix(n, 1, 10);

        System.out.println("Matriz A:"); printMatrix(A);
        System.out.println("Matriz B:"); printMatrix(B);

        System.out.println("Suma:"); printMatrix(addMatrices(A, B));
        System.out.println("Producto:"); printMatrix(multiplyMatrices(A, B));
    }

    public static int[][] generateRandomMatrix(int n, int min, int max) {
        Random r = new Random();
        int[][] M = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                M[i][j] = r.nextInt(max - min + 1) + min;
        return M;
    }

    public static void printMatrix(int[][] M) {
        for (int[] row : M) {
            for (int val : row) System.out.printf("%4d", val);
            System.out.println();
        }
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] R = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                R[i][j] = A[i][j] + B[i][j];
        return R;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] R = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    R[i][j] += A[i][k] * B[k][j];
        return R;
    }

    // ========================= SECCIÓN GRAFOS (con gráfico) =========================
    public static void menuGrafos() {
        System.out.println("\n--- GRAFOS ---");
        System.out.print("Ingrese número de vértices: ");
        int n = readInt();
        if (n <= 0) { System.out.println("Número inválido."); return; }
        System.out.print("Ingrese número de aristas: ");
        int m = readInt();

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        System.out.println("Ingrese aristas (origen destino) con índices 0.." + (n-1) + " :");
        for (int i = 0; i < m; i++) {
            System.out.print("Arista " + (i+1) + ": ");
            int u = readInt();
            int v = readInt();
            if (u < 0 || v < 0 || u >= n || v >= n) {
                System.out.println("Arista inválida, se omite.");
                continue;
            }
            adjList.get(u).add(v);
            adjList.get(v).add(u); // grafo no dirigido
        }

        System.out.println("\nLista de adyacencia:");
        for (int i = 0; i < n; i++) System.out.println(i + " -> " + adjList.get(i));

        System.out.println("\nMatriz de adyacencia:");
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int v : adjList.get(i))
                matrix[i][v] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

        // Ventana gráfica
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Grafo (" + n + " vértices)");
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.add(new GraphPanel(adjList));
            f.setSize(700, 700);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }

    static class GraphPanel extends JPanel {
        private final List<List<Integer>> adjList;
        GraphPanel(List<List<Integer>> adjList) { this.adjList = adjList; }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int n = Math.max(1, adjList.size());
            int cx = getWidth() / 2, cy = getHeight() / 2;
            int radius = Math.min(cx, cy) - 80;
            Point[] pts = new Point[n];
            for (int i = 0; i < n; i++) {
                double ang = 2 * Math.PI * i / n;
                pts[i] = new Point((int)(cx + radius * Math.cos(ang)), (int)(cy + radius * Math.sin(ang)));
            }

            // Dibujar aristas (una sola vez por par)
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.GRAY);
            for (int i = 0; i < n; i++) {
                for (int v : adjList.get(i)) {
                    if (i < v && v >= 0 && v < n) {
                        g2.draw(new Line2D.Double(pts[i].x, pts[i].y, pts[v].x, pts[v].y));
                    }
                }
            }

            // Dibujar nodos
            int nodeR = 28;
            for (int i = 0; i < n; i++) {
                g2.setColor(new Color(70,130,180));
                g2.fillOval(pts[i].x - nodeR/2, pts[i].y - nodeR/2, nodeR, nodeR);
                g2.setColor(Color.BLACK);
                g2.drawOval(pts[i].x - nodeR/2, pts[i].y - nodeR/2, nodeR, nodeR);
                FontMetrics fm = g2.getFontMetrics();
                String label = String.valueOf(i);
                int lw = fm.stringWidth(label);
                g2.drawString(label, pts[i].x - lw/2, pts[i].y + fm.getAscent()/2 - 2);
            }
        }
    }

    // ========================= SECCIÓN ÁRBOLES BINARIOS (con gráfico) =========================
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void menuArboles() {
        System.out.println("\n--- ÁRBOLES BINARIOS ---");
        System.out.print("Ingrese número de niveles (>=1): ");
        int niveles = readInt();
        if (niveles < 1) { System.out.println("Niveles inválidos."); return; }

        int maxVertices = (int)Math.pow(2, niveles) - 1;
        System.out.print("Ingrese cuántos vértices desea (1.." + maxVertices + "): ");
        int vertices = readInt();
        if (vertices < 1 || vertices > maxVertices) { System.out.println("Cantidad inválida."); return; }

        System.out.println("Ingrese los valores de los nodos (enteros). Si desea random, ingrese 'r' y presione Enter.");
        List<Integer> values = new ArrayList<>();
        String line = sc.nextLine();
        if (line.equalsIgnoreCase("r")) {
            Random rng = new Random();
            for (int i = 0; i < vertices; i++) values.add(rng.nextInt(100));
        } else {
            if (!line.trim().isEmpty()) {
                try { values.add(Integer.parseInt(line.trim())); } catch (Exception ex) { /* ignore */ }
            }
            while (values.size() < vertices) {
                System.out.print("Valor nodo " + (values.size()+1) + ": ");
                values.add(readInt());
            }
        }

        TreeNode root = buildTreeFromList(values);
        System.out.println("Número de vértices: " + vertices);

        // Ventana gráfica
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Árbol Binario (" + vertices + " nodos)");
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.add(new TreePanel(root));
            f.setSize(900, 600);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });

        System.out.println("\nRecorridos:");
        System.out.print("Pre-orden: "); preorder(root); System.out.println();
        System.out.print("In-orden: "); inorder(root); System.out.println();
        System.out.print("Post-orden: "); postorder(root); System.out.println();
    }

    public static TreeNode buildTreeFromList(List<Integer> vals) {
        if (vals.isEmpty()) return null;
        List<TreeNode> nodes = new ArrayList<>();
        for (Integer v : vals) nodes.add(new TreeNode(v));
        for (int i = 0; i < nodes.size(); i++) {
            int leftIdx = 2*i + 1;
            int rightIdx = 2*i + 2;
            if (leftIdx < nodes.size()) nodes.get(i).left = nodes.get(leftIdx);
            if (rightIdx < nodes.size()) nodes.get(i).right = nodes.get(rightIdx);
        }
        return nodes.get(0);
    }

    static class TreePanel extends JPanel {
        private final TreeNode root;
        TreePanel(TreeNode root) { this.root = root; }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (root == null) return;
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int startX = getWidth() / 2;
            int startY = 50;
            int initialOffset = Math.max(40, getWidth() / 6);
            drawTree(g2, root, startX, startY, initialOffset);
        }

        private void drawTree(Graphics2D g2, TreeNode node, int x, int y, int offset) {
            if (node == null) return;
            int r = 28;

            // dibujar líneas a hijos
            if (node.left != null) {
                int childX = x - offset;
                int childY = y + 90;
                g2.setColor(Color.DARK_GRAY);
                g2.setStroke(new BasicStroke(2));
                g2.drawLine(x, y, childX, childY);
                drawTree(g2, node.left, childX, childY, Math.max(20, offset/2));
            }
            if (node.right != null) {
                int childX = x + offset;
                int childY = y + 90;
                g2.setColor(Color.DARK_GRAY);
                g2.setStroke(new BasicStroke(2));
                g2.drawLine(x, y, childX, childY);
                drawTree(g2, node.right, childX, childY, Math.max(20, offset/2));
            }

            // dibujar nodo
            g2.setColor(new Color(173,216,230));
            g2.fillOval(x - r/2, y - r/2, r, r);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(1));
            g2.drawOval(x - r/2, y - r/2, r, r);

            String label = String.valueOf(node.val);
            FontMetrics fm = g2.getFontMetrics();
            int lw = fm.stringWidth(label);
            g2.drawString(label, x - lw/2, y + fm.getAscent()/2 - 2);
        }
    }

    // Recorridos de árbol
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // ========================= UTILIDADES =========================
    public static int readInt() {
        while (true) {
            try {
                String line = sc.nextLine();
                return Integer.parseInt(line.trim());
            } catch (Exception e) {
                System.out.print("Entrada inválida. Intente de nuevo: ");
            }
        }
    }

    // ========================= MAIN =========================
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Conjuntos");
            System.out.println("2. Combinatoria");
            System.out.println("3. Recursividad");
            System.out.println("4. Números Primos");
            System.out.println("5. Máximo común divisor y Mínimo común múltiplo");
            System.out.println("6. Matrices");
            System.out.println("7. Grafos");
            System.out.println("8. Árboles binarios");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = readInt();

            switch (opcion) {
                case 1: menuConjuntos(); break;
                case 2: menuCombinatoria(); break;
                case 3: menuRecursividad(); break;
                case 4: menuPrimos(); break;
                case 5: menuMcdMcm(); break;
                case 6: menuMatrices(); break;
                case 7: menuGrafos(); break;
                case 8: menuArboles(); break;
                case 9: salir = true; break;
                default: System.out.println("Opción inválida.");
            }
        }
        System.out.println("Programa finalizado.");
        System.exit(0);
    }
}
