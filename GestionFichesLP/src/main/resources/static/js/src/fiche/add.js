$(document).ready(function () {
      request = $.ajax({
        type: "GET",
        url: "http://localhost:4040/fiche/config",
        error: function(xhr,textStatus,err)
        {console.log("readyState: " + xhr.readyState);
          console.log("responseText: "+ xhr.responseText);
          console.log("status: " + xhr.status);
          console.log("text status: " + textStatus);
          console.log("error: " + err);
        },
        success: function(xml) {
            console.log(xml);
            console.log($.parseXML(xml));
            display($.parseXML(xml));
        }
      });

    });

    function getHTMLChampsType(champs,i){
      var ret = '';
      var name ;
      if(i==-1){
        name = champs.children("nom").text();
      }else{
        name = champs.children("nom").text()+''+i;
      }
      switch (champs.children("type").text()) {
        case 'textarea':
        ret += '<textarea name="'+name+'" rows="5"></textarea>';
        break;
        case 'select':
        ret += '<select name="'+name+'">';
          ret += Configuration[champs.children("value").text()].html();
          ret += '</select>';
          break;
          case 'radio':
          Configuration[champs.children("value").text()].children('option').each(function(){
            ret += '<input type="radio" name="'+name+'" value="'+$(this).text()+'">';
            ret +=  $(this).text();

          });
        }
        return ret;
      }
      function display(xml){
      var Champs = new Array();
      Configuration = new Array();
        $(xml).find('Fiche').each(function(){
          $(this).find('configuration').each(function(){
            $(this).children().each(function(){
              Configuration[$(this)[0].tagName] = $(this);
            });
          });
          var i =0;
          $(this).find('champs').each(function(){
            var display = false;
            $(this).children('periode').find('numero').each(function(){
              if($(this).text() == 1){
                display = true;
              }
            });
            if(display){
              Champs[i++] = $(this);
            }
          });
          $(this).find('table').each(function(){
            var quantite = parseInt($(this).children("quantite").text());
            html = '<table class="ui celled table">';
              for(var i = 0;i<quantite+1;i++){
                html += '<tr>';
                  $(this).find('champs').each(function(){
                    var position = parseInt($(this).text());
                    if(i==0){
                      html += '<th>'+Champs[position].children("titre").text()+'</th>';
                    }else{
                      html += '<td>';
                        html += getHTMLChampsType(Champs[position],i);
                        html += '</td>';
                        if(i==quantite){
                          Champs.splice(position,1);
                        }
                      }
                    });
                    /*if(i==0){
                    html += '<th>Actions</th>';
                  }else{
                  html += '<td>';
                  html += '<button type="button" name="button" id=ajouter'+i+'>Ajouter</button>';
                  html += '<button type="button" name="button" id=vider'+i+'>Vider</button>';
                  html += '<button type="button" name="button" id=supprimer'+i+'>Supprimer</button>';
                  html += '</td>';
                }*/
                html += '</tr>';
              }
              html += '</table>';
            });
          });
          for (var i = 0; i < Champs.length; i++) {
            html += Champs[i].children("titre").text();
            html += '<br/>';
            html += getHTMLChampsType(Champs[i],-1);
            html += '<br/>';
          }
          $("#a").html(html);
          console.log("Fini");
        }

