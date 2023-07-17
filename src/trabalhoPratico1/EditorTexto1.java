package trabalhoPratico1;


import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class EditorTexto1 {
    static int MAX_SIZE = 100;
    static String[] lines = new String[MAX_SIZE];
    static int[] wordCount = new int[MAX_SIZE];
    static int[] charCount = new int[MAX_SIZE];
    static boolean[] isDeleted = new boolean[MAX_SIZE];
    static int lineCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("(I)nserir linhas no fim(termine com uma linha vazia");
            System.out.println("(L)istar linhas");
            System.out.println("(A)pagar ultima linha");
            System.out.println("(E)ditar");
            System.out.println("(F)erramentas");
            System.out.println("(S)air");
            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "I":
                    while(true){
                    System.out.println("Inserir Linhas/ Linha vazia para terminar");
                    String line = scanner.nextLine();
                    if (line.isEmpty()){
                        break;
                    }
                    if(lineCount >= MAX_SIZE){
                    System.out.println("Não é possível inserir mais linhas. O limite máximo foi atingido.");
                    break;
                    }
                    lines[lineCount] = line;
                    wordCount[lineCount] = line.split("\\s+").length;
                    charCount[lineCount] = line.replace("", "").length();
                    isDeleted[lineCount] = false;
                    lineCount ++;

                }
                    break;


                case "L":
                    System.out.println("Listando Linhas:");
                    for (int i = 0; i < lineCount; i++){
                        if (!isDeleted[i]){
                            System.out.println((i +1) + ": " + lines[i]);
                        }
                    }
                    break;

                case "A":
                    if (lineCount > 0){
                        isDeleted[lineCount -1] = true;
                            System.out.println("A ultima linha foi apagada");
                    } else {
                        System.out.println("Não há linhas para apagar.");
                    }
                    break;
            //MENU EDITAR
                case "E":
                    boolean isEditing = true;
                    while (isEditing) {
                        System.out.println("Menu Editar:");
                        System.out.println("(I)nserir linha na posição n");
                        System.out.println("(A)pagar linha na posiçao n");
                        System.out.println("Apagar (l)inhas da posição n á posição m");
                        System.out.println("(R)ecuperar linha");
                        System.out.println("(E)liminar linhas apagadas");
                        System.out.println("(V)oltar");
                        String editOption = scanner.nextLine().toUpperCase();

                        switch (editOption) {
                            case "I":
                                System.out.println("Digita a posição onde inserir a linha:");
                                int position = Integer.parseInt(scanner.nextLine()) - 1;
                                if (position < 0 || position > lineCount) {
                                    System.out.println("Posição inválida");
                                } else {
                                    System.out.println("Digite a linha para inserir:");
                                    String line = scanner.nextLine();
                                    for (int i = lineCount; i > position; i--) {
                                        lines[i] = lines[i - 1];
                                        wordCount[i] = wordCount[i - 1];
                                        charCount[i] = charCount[i - 1];
                                        isDeleted[i] = isDeleted[i - 1];
                                    }
                                    lines[position] = line;
                                    wordCount[position] = line.split("\\s+").length;
                                    charCount[position] = line.replace("", "").length();
                                    isDeleted[position] = false;
                                    lineCount++;

                                }
                                break;

                            case "A":
                                System.out.println("Digita a posição da linha para apagar:");
                                int positionToDelete = Integer.parseInt(scanner.nextLine()) - 1;

                                if (positionToDelete < 0 || positionToDelete >= lineCount) {
                                    System.out.println("Posição inválida.");
                                } else {
                                    for (int i = positionToDelete; i < lineCount - 1; i++) {
                                        lines[i] = lines[i + 1];
                                        wordCount[i] = wordCount[i + 1];
                                        charCount[i] = charCount[i + 1];
                                        isDeleted[i] = isDeleted[i + 1];
                                    }
                                    lineCount--;
                                    System.out.println("Linha apagada");
                                }
                                break;
                            case "L":
                                System.out.println("Digite a posição inicial e final para apagar as linhas:");
                                int startPosition = Integer.parseInt(scanner.nextLine()) - 1;
                                int endPosition = Integer.parseInt(scanner.nextLine()) - 1;

                                if (startPosition < 0 || endPosition >= lineCount || startPosition > endPosition){
                                    System.out.println("Posiçoes inválidas");
                                }else {
                                    for (int i = startPosition; i <= endPosition; i++){
                                        isDeleted[i] = true;
                                    }
                                    System.out.println("Linhas apagadas.");
                                }
                                break;

                            case "R":
                                System.out.println("Digite a posição da linha para recuperar.");
                                int positionRecover = Integer.parseInt(scanner.nextLine()) - 1;
                                if (positionRecover < 0 || positionRecover >= lineCount){
                                    System.out.println("Posição invalida.");
                                } else if (isDeleted[positionRecover]){
                                    System.out.println("A linha não esta apagada");
                                } else {
                                    isDeleted[positionRecover] = false;
                                    System.out.println("Linha recuperada");
                                }
                                break;

                            case "E":
                                int shift = 0;
                                for (int i = 0; i < lineCount; i++){
                                    if (isDeleted[i]){
                                        shift++;
                                    } else if (shift > 0) {
                                        lines[i - shift] = lines[i];
                                        wordCount[i - shift] = wordCount[i];
                                        charCount[i - shift] = charCount[i];
                                        isDeleted[i - shift] = isDeleted[i];
                                    }
                                }
                                lineCount -= shift;
                                System.out.println("Linhas apagadas eliminadas.");
                                break;

                            case "V":
                                isEditing = false;
                                break;

                            default:
                                System.out.println("Opção invalida.Por favor, tente novamente");
                        }
                    }
                    break;

//Menu Ferramentas
                case "F":
                    boolean isUsingTools = true;
                    while (isUsingTools) {
                        System.out.println("Menu Ferramentas:");
                        System.out.println("Menu Ferramentas:");
                        System.out.println("(M)ostrar linhas onde ocorre a palavra p.");
                        System.out.println("(S)ubstituir a palavra p na linha n.");
                        System.out.println("Mostrar número de (l)inhas.");
                        System.out.println("Mostrar número de (p)palavras.");
                        System.out.println("Mostrar número de (c)aracteres.");
                        System.out.println("(V)oltar.");
                        String toolsOption = scanner.nextLine().toUpperCase();

                        switch (toolsOption){
                            case "M":
                                // código para prucurar palavra
                                System.out.println("Digite a palavra  para procurar:");
                                String wordToFind = scanner.nextLine();
                                for (int i = 0; i < lineCount; i++){
                                    if (isDeleted[i] && lines[i].contains(wordToFind)){
                                        System.out.println((i + 1) + ": " + lines[i]);
                                    }
                                }
                                break;
                            case "S":
                                // código para substituir palavra
                                System.out.println("Digite a posição da linha:");
                                int linePosition = Integer.parseInt(scanner.nextLine()) - 1;

                                if (linePosition < 0 || linePosition >= lineCount || isDeleted[linePosition]){
                                    System.out.println("Posição invalida.");
                                } else {
                                    System.out.println("Digite a palavra para substituir: ");
                                    String wordToReplace = scanner.nextLine();
                                    System.out.println("Digita a nova palavra:");
                                    String newWord = scanner.nextLine();
                                    lines[linePosition] = lines[linePosition].replace(wordToReplace, newWord);
                                    wordCount[linePosition] = lines[linePosition].split("\\s+").length;
                                    charCount[linePosition] = lines[linePosition].replace(" ", " ").length();
                                    System.out.println("Palavra sbstituida.");
                                }
                                break;
                            case "L":
                                // código para mostrar número de linhas
                                int activeLines = 0;
                                for (boolean deleted : isDeleted){
                                    if (!deleted){
                                        activeLines++;
                                    }
                                }
                                System.out.println("Numero de linhas: " + activeLines);
                                break;
                            case "P":
                                // código para mostrar número de palavras
                                int totalWords = 0;
                                for (int i = 0; i < lineCount; i++){
                                    if (!isDeleted[i]){
                                        totalWords += wordCount[i];
                                    }
                                }
                                System.out.println("Numero de palavras: " + totalWords);
                                break;

                            case "C":
                                // código para mostrar número de caracteres
                                int totalChars = 0;
                                for (int i = 0; i < lineCount; i++){
                                    if (!isDeleted[i]){
                                        totalChars += charCount[i];
                                    }
                                }
                                System.out.println("Número de caracteres: " + totalChars);
                                break;

                            case "V":
                                isUsingTools = false;
                                break;

                            default:
                                System.out.println("Opção invalida. Por favor, tente novamente");
                        }
                    }
                    break;

                case "S":
                    isRunning = false;
                    break;

                default:
                    System.out.println("Opção Invalida. Por favor tente de novo");
            }


        }
        scanner.close();
    }
}