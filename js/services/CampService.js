module.exports = {

    name: "CampService",
    func: function () {


function Set(name, number, theme, pieces, status, image) {
            this.title = name;
            this.setNumber = number;
            this.theme = theme;
            this.pieces = pieces;
            this.status = status;
            this.image = image;


            return this;
        }


        let sets = [];

        sets.push(new Set('Space Moon Buggy', '3365-1', 'City', 37, 'Available', 'http://images.brickset.com/sets/images/3365-1.jpg?201012090229'));
        sets.push(new Set('The First Night', '21115-1', 'Minecraft', 408, 'Checked Out', 'http://images.brickset.com/sets/large/21115-1.jpg?201410080618'));
        sets.push(new Set('The Batcave','6860-1', 'Super Heroes', 690, 'Missing Pieces', 'http://images.brickset.com/sets/images/6860-1.jpg?201110150701'));
        sets.push(new Set('Death Star','10188-1', 'Star Wars', 3803, 'On Display', 'http://images.brickset.com/sets/AdditionalImages/10188-1/10188-0000-xx-13-1.jpg'));

        console.log(sets);

        return {

            getSets() {

                return sets;
            },



        }

    }
};

