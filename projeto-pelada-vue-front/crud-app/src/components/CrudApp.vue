<template>
    <div style="margin: 0 auto; width: 80%">
       <Panel header="Peladas"> 
         <Menubar :model="items"/>
         <br/>
         <DataTable :value="peladas" :paginator="true" :rows="10" selectionMode="single" :selection.sync="selectedPelada" datakey="id">
            <Column field="id" header="ID"></Column>
            <Column field="nome" header="Nome"></Column>
            <Column field="local" header="Local"></Column>
            <Column field="hora" header="Hora"></Column>
            <Column field="data" header="Data"></Column>
            <Column field="usuario.nomeCompleto" header="Usuario"></Column>
         </DataTable>
       </Panel> 
       <Dialog header="Nova Pelada" :visible.sync="displayModal"  :modal="true">
            <span class="p-float-label">
              <InputText id="nome" type="text" v-model="pelada.nome" style="width: 100%"/>
              <label for="nome">Nome</label>
            </span>
            <span class="p-float-label">
              <InputText id="local" type="text" v-model="pelada.local" style="width: 100%"/>
              <label for="local">Local</label>
            </span>
            <span class="p-float-label">
              <InputText id="hora" type="text" v-model="pelada.hora" style="width: 100%"/>
              <label for="hora">Hora</label>
            </span>
            <span class="p-float-label">
              <InputText id="data" type="text" v-model="pelada.data" style="width: 100%"/>
              <label for="data">Data</label>
            </span>
            <template #footer>
                <Button label="Salvar" icon="pi pi-check" @click="save"/>
                <Button label="Cancelar" icon="pi pi-times" @click="closeModal" class="p-button-secondary" />
            </template>
       </Dialog>    
    </div>
</template>

<script>
import PeladaService from '../service/PeladaService';
export default {
    name: 'CrudApp',
    data() {
        return {
            peladas : null,
            pelada : {
                id : null,
                nome : null,
                local : null,
                hora : null,
                data : null

            },
            selectedPelada : {
                id : null,
                nome : null,
                local : null,
                hora : null,
                data : null
            },
            items : [
                {
                    label : 'Novo',
                    icon : 'pi pi-fw pi-plus',
                    command : () => {
                         this.showSaveModal();
                    }
                },
                {
                    label : 'Editar',
                    icon : 'pi pi-fw pi-pencil',
                    command : () => {
                         this.showEditModal(); 
                    }
                },
                {
                    label : 'Deletar',
                    icon : 'pi pi-fw pi-trash',
                    command : () => {
                         this.delete();
                    }
                },
                {
                    label : 'Atualizar',
                    icon : 'pi pi-fw pi-refresh',
                    command : () => {
                         this.getAll();
                    }
                }
            ],
            displayModal : false
        }
    },
   peladaService : null,
   created() {
       this.peladaService = new PeladaService();
   },
   mounted() {
       this.getAll(); 
   },
   methods : {
       showSaveModal() {
           this.displayModal = true;
       },
       showEditModal() {
           this.pelada = this.selectedPelada;
           this.displayModal = true;
       },
       getAll() {
           this.peladaService.getAll().then(data => {
           this.peladas = data.data;
           });
       },
       delete() {
           this.peladaService.delete(this.selectedPelada.id).then(data => {
           if(data.status === 200) {
                this.getAll();
           }
           });  
       },
       save() {
           this.peladaService.save(this.pelada).then(data => {
             if(data.status === 200) {
                 this.displayModal = false;
                 this.pelada = {
                     nome : null,
                     local : null,
                     hora : null,
                     data : null
                 }
                 this.getAll();

             }
           })
       },
       closeModal() {
           this.displayModal = false;
       }
   }
}
</script>

<style>

</style>