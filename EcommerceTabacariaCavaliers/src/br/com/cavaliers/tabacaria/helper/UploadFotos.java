package br.com.cavaliers.tabacaria.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UploadFotos 
{

    public void upload(String caminho, String nome, int id, InputStream arquivoCarregado) 
    {
        String caminhoArquivo = caminho + "/" + nome + ".jpeg";
        File novoArquivo = new File(caminhoArquivo);

        try 
        {
            FileOutputStream saida = new FileOutputStream(novoArquivo);
            copiarBites(arquivoCarregado, saida);
        } 
        catch (FileNotFoundException fileNotFoundException) 
        {
            fileNotFoundException.printStackTrace();
        }
    }

    public void copiarBites(InputStream origem, OutputStream destino)
    {
        int bite = 0;

        byte[] tamanhoMaximo = new byte[1024 * 80];

        try 
        {
            while ((bite = origem.read(tamanhoMaximo)) >= 0)
            {
                destino.write(tamanhoMaximo, 0, bite);
            }
        }
        catch (IOException ioException) 
        {
            ioException.getStackTrace();
        }
    }   

}
