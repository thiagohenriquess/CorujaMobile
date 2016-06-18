package br.com.faeterj.corujamobile.mensagens.entrada.Repository;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.faeterj.corujamobile.mensagens.entrada.Model.Mensagem;
import br.com.faeterj.corujamobile.R;


/**
 * Created by thiago on 08/06/16.
 */
public class BancoAdapterMensagem extends ArrayAdapter<Mensagem> {

    private int resource =0;
    private LayoutInflater inflater;

    BancoAdapterMensagem(Context context, int resource){

        super(context,resource);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resource = resource;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        ViewHolder viewHolder;

        if(convertView == null){

            viewHolder = new ViewHolder();

            view = inflater.inflate(resource, parent, false);

            viewHolder.imagemViewRemetente = (ImageView) view.findViewById(R.id.imagem_remetente_mensagem);
            viewHolder.conteudoView = (TextView) view.findViewById(R.id.conteudo_mensagem);
            viewHolder.nomeRemetenteView = (TextView) view.findViewById(R.id.nome_remetente_mensagem);
            viewHolder.tituloView =  (TextView) view.findViewById(R.id.titulo_mensagem);

            view.setTag(viewHolder);

            convertView = view;

        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();

            view = convertView;
        }

        Mensagem mensagem = getItem(position);

        viewHolder.nomeRemetenteView.setText(mensagem.getRemetente().getNome());
        viewHolder.tituloView.setText(mensagem.getTitulo());
        viewHolder.conteudoView.setText(mensagem.getConteudo());


        return view;
    }

    public static class ViewHolder{
        ImageView imagemViewRemetente;
        TextView tituloView;
        TextView nomeRemetenteView;
        TextView conteudoView;

    }
}
