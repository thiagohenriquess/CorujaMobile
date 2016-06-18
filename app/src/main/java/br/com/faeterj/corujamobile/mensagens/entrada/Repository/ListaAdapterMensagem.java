package br.com.faeterj.corujamobile.mensagens.entrada.Repository;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.faeterj.corujamobile.mensagens.entrada.Model.Mensagem;
import br.com.faeterj.corujamobile.R;

/**
 * Created by thiago on 01/06/16.
 */
public class ListaAdapterMensagem extends ArrayAdapter<Mensagem> {

    private Context context;
    private List<Mensagem> listMensagem = null;

    public ListaAdapterMensagem(Context context, List<Mensagem> listMensagem){
        super(context, 0, listMensagem);
        this.context = context;
        this.listMensagem = listMensagem;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        Mensagem mensagem = listMensagem.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_layout_mensagens, null);

        //Cria e associa a imagem view ao layout de item_remtente_mensagem Depois seta ela
        ImageView imagemViewRemetente = (ImageView) view.findViewById(R.id.imagem_remetente_mensagem);
        imagemViewRemetente.setImageResource(mensagem.getRemetente().getImg());

        //Cria e associa o titulod ao layout de titulo_mensagem Depois seta ela
        TextView tituloView = (TextView) view.findViewById(R.id.titulo_mensagem);
        tituloView.setText(mensagem.getTitulo());

        //Cria e associa o nome ao layout de nome_remetente_mensagem Depois seta ela
        TextView nomeRemetenteView = (TextView) view.findViewById(R.id.nome_remetente_mensagem);
        nomeRemetenteView.setText(mensagem.getRemetente().getNome());

        //Cria e associa o conteudo ao layout de titulo_mensagem Depois seta ela
        TextView conteudoView = (TextView) view.findViewById(R.id.conteudo_mensagem);
        conteudoView.setText(mensagem.getConteudo());

        return view;
    }

}

